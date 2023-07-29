package com.github.mrs.service;

import com.github.mrs.vo.ResponseVO;

public interface UserService {

    ResponseVO bindUserIdAndToken(String token, String uuid);

}
