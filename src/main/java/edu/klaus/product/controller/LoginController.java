package edu.klaus.product.controller;

import edu.klaus.product.business.model.LoginDTO;
import edu.klaus.product.util.ResponseMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @PostMapping()
    public ResponseMessage login(@RequestBody LoginDTO loginDTO) {

        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(loginDTO.getUserName());

        return responseMessage;
    }
}
