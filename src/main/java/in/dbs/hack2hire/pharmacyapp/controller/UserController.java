package in.dbs.hack2hire.pharmacyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.dbs.hack2hire.pharmacyapp.api.service.UserService;
import in.dbs.hack2hire.pharmacyapp.vo.UserVO;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@RequestMapping(value = "get/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserVO getUser(@PathVariable("userName") String userName) {
		return userService.getUser(userName);
	}

	@RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserVO saveUser(@RequestBody UserVO userVO) {
		return userService.saveUser(userVO);
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserVO> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "sendmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("tech.deepak5@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");
        
        javaMailSender.send(msg);
        
		return "Success";
	}
}
