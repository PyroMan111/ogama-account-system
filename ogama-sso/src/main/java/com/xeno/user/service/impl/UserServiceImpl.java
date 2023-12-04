package com.xeno.user.service.impl;

import com.xeno.user.entity.User;
import com.xeno.user.mapper.UserMapper;
import com.xeno.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 作者
 * @since 2023-12-04
 */
@Primary
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
