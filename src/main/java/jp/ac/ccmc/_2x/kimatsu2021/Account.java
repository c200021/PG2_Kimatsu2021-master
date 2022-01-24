package jp.ac.ccmc._2x.kimatsu2021;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	private String className;

	@NotEmpty
	@Pattern(regexp = "0\\d{1,4}-\\d{1,4}-\\d{4}", message="電話番号の形式で入力してください 例 xxxx-xxxx-xxxx")
	private String tel;

	@NotEmpty
	private String address;

	public Account() {
		super();
	}

	public Account(String name, String className, String tel, String address) {
		super();
		this.name = name;
        this.className = className;
		this.tel = tel;
		this.address = address;
	}
}