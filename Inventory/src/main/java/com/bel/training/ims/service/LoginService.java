package com.bel.training.ims.service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bel.training.ims.model.Dealer;
import com.bel.training.ims.repository.DealerRepository;
import com.bel.training.ims.repository.UserRepository;

@Service
@Transactional
public class LoginService {

	@Autowired
	private DealerRepository drepo;
	
	@Autowired
	private UserRepository urepo ;
	
	public void saveDealer(Dealer dealer)
	{
		drepo.save(dealer);  //invokes save mthod of JPA repository
	}
	public Dealer findByEmail(String email)
	{
		return urepo.findByEmail(email);
	}
}
