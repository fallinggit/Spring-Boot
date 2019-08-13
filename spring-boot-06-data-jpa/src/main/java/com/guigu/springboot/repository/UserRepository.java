package com.guigu.springboot.repository;

import com.guigu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Dao接口
//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {


}
