package model.entity;

import java.io.Serializable;

/**
 * 従業員を表します。
 * m_employeeのDTOであり、Beanオブジェクトです。
 * @author emBex Education
 */
public class UserBean implements Serializable {
	/**
	 * id
	 */
	private String user_id;

	/**
	 * pass
	 */
	private String password;

	/**
	 * name
	 */
	private String name;

	/**
	 * age
	 */
	private int age;

	/**
	 * EmployeeBeanを構築します。
	 */
	public UserBean() {

	}

	/**
	 * フィールドcodeの値を返します。
	 * @return コード
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * フィールドcodeの値を設定します。
	 * @param code コード
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * フィールドnameの値を返します。
	 * @return 氏名
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * フィールドnameの値を設定します。
	 * @param name 氏名
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * フィールドageの値を返します。
	 * @return 年齢
	 */
	public String getName() {
		return name;
	}

	/**
	 * フィールドageの値を設定します。
	 * @param age 年齢
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * フィールドsectionの値を返します。
	 * @return 部署
	 */
	public int getAge() {
		return age;
	}

	/**
	 * フィールドsectionの値を設定します。
	 * @param section 部署
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
