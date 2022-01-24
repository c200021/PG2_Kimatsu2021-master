package jp.ac.ccmc._2x.kimatsu2021;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	public List<Account> listAll(){
		return repo.findAll();
	}

	public void save(Account account) {
		repo.save(account);
	}

	public Account get(long id) {
		return repo.getById(id);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}