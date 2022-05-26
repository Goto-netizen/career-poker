package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.entity.CardBean;
import model.entity.GeneralProcessing;

/**
 * Servlet implementation class ProcessingServlet
 */
@WebServlet("/ProcessingServlet")
public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//本当はパラメータ名handで統一して値を0と7で分けた方が良い
		/*int handNumber = Integer.parseInt(request.getParameter("hand"));
		int  pass = Integer.parseInt(request.getParameter("pass"));
		boolean cardPlayFlag = false;//カード出せるかどうか判定*/
		
		int index = Integer.parseInt(request.getParameter("index"));
		boolean endGameFlag = false;
		
		List<CardBean> playerHandList = new ArrayList<>(); 
		List<CardBean> CPUHandList = new ArrayList<>(); 
		List<CardBean> fieldList = new ArrayList<>(); 
		List<CardBean> discardFieldList = new ArrayList<>();
		
		/*for(int i=1;i<=3;i++){
			playerHandList.add(new DistributionBean((i+6),"♤",i));
		}

		for(int i=1;i<=3;i++){
			CPUHandList.add(new DistributionBean((i+6),"♡",i));
		}*/
		
		/*
		for(int i=1;i<=3;i++){
			fieldList.add(new TestBean((i+5),"♦",i-1));
		}*/
		/*fieldList.add(new DistributionBean(8,"♦",3));*/
		
		
		boolean canPlayFlag = false;
		
		
		HttpSession session = request.getSession();
		GeneralProcessing gp = new GeneralProcessing(playerHandList,CPUHandList,fieldList,discardFieldList);
		
		canPlayFlag = gp.judge(index);
		
		/*ここから*/
		if(canPlayFlag) {//プレイヤーが出せるカードを選んだ時
			try {
				gp.playerProcess(index);//プレイヤーの処理
				if(gp.getPlayerPassFlag() == true) {//プレイヤーがパスをした時
					gp.endRound();
				}
				endGameFlag = gp.checkHandSize();//プレイヤーの手札が無くなったか判定
				if(endGameFlag == true) {//プレイヤーの手札が0の時
					//session.setAttribute("勝者");
					//終了.jspへ
				}
				gp.CPUProcess();//CPUの処理
				if(gp.getCPUPassFlag() == true) {//CPUがパスをした時
					gp.endRound();
				}
				endGameFlag = gp.checkHandSize();
				if(endGameFlag == true) {
					//session.setAttribute("勝者");
					//終了.jspへ
				}
			
			
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		else {
			//出せませんよ表示.jsp
		}
		/*ここまで*/
		
		playerHandList = gp.getPlayerHandList();
		CPUHandList = gp.getCPUHandList();
		fieldList = gp.getFieldList();
		discardFieldList = gp.getDiscardFieldList();
		
		
		session.setAttribute("index",index);
		session.setAttribute("pList",playerHandList);
		session.setAttribute("cpuList",CPUHandList);
		session.setAttribute("fList",fieldList);
		session.setAttribute("dList",discardFieldList);
		
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("selectHandTest.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	}

}
/*
		if(pass==0) {
			CPUHandList = gp.CPUProcess(CPUHandList);
		}
		else {
			cardPlayFlag = //判定処理();
			if(cardPlayFlag = true) {//カードが出せるか
				playerHandList = gp.handProcessing();
				CPUHandList = gp.CPUProcess(CPUHandList);
			}
		}*/