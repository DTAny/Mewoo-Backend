package com.github.dtanything.mewoobackend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.dtanything.mewoobackend.pojo.Memo;
import com.github.dtanything.mewoobackend.pojo.User;
import com.github.dtanything.mewoobackend.service.MemoService;
import com.github.dtanything.mewoobackend.service.UserService;
import com.github.dtanything.mewoobackend.utils.Hjq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/mewoo")
public class MyController {
    @Autowired
    UserService userService;
    @Autowired
    MemoService memoService;

    @PostMapping("/login")
    Map<String, Object> login(@RequestBody User user){
        if (userService.verifyUser(user)){
            return new Hjq()
                    .add("status", 200)
                    .getRes();
        }
        else {
            return new Hjq()
                    .add("status", 403)
                    .add("error", "账号或密码错误")
                    .getRes();
        }
    }

    @GetMapping("/memo")
    Map<String, Object> getAll(){
        return new Hjq()
                .add("status", 200)
                .add("res", memoService.list())
                .getRes();
    }

    @PostMapping("/memo")
    Map<String, Object> addMemo(@RequestBody Memo memo){
        memo.setTime(new Date());
        if (memoService.save(memo))
            return new Hjq()
                    .add("status", 200)
                    .getRes();
        else
            return new Hjq()
                    .add("status", 500)
                    .add("error", "服务器内部错误")
                    .getRes();
    }

    @DeleteMapping("/memo/{mid}")
    Map<String, Object> removeMemo(@PathVariable Integer mid){
        if (memoService.remove(new QueryWrapper<Memo>().eq("mid", mid))){
            return new Hjq()
                    .add("status", 200)
                    .getRes();
        }
        else {
            return new Hjq()
                    .add("status", 404)
                    .add("error", "该条备忘录已被删除")
                    .getRes();
        }
    }

    @PutMapping("/memo/{mid}")
    Map<String, Object> editMemo(@PathVariable Integer mid, @RequestBody Map<String, Object> json){
        Memo memo = memoService.getById(mid);
        if (memo == null){
            return new Hjq()
                    .add("status", 404)
                    .add("error", "该条备忘录已被删除")
                    .getRes();
        }
        memo.setUid((Integer) json.get("uid"));
        memo.setContent((String) json.get("content"));
        memo.setTime(new Date());
        if (memoService.updateById(memo)){
            return new Hjq()
                    .add("status", 200)
                    .getRes();
        }
        else {
            return new Hjq()
                    .add("status", 404)
                    .add("error", "该条备忘录已被删除")
                    .getRes();
        }
    }

    @PutMapping("/user/{uid}")
    Map<String, Object> editUser(@PathVariable Integer uid, @RequestBody User user){
        user.setUid(uid);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes(StandardCharsets.UTF_8)));
        if (userService.updateById(user)){
            return new Hjq()
                    .add("status", 200)
                    .getRes();
        }
        else {
            return new Hjq()
                    .add("status", 404)
                    .add("error", "未找到该用户")
                    .getRes();
        }
    }
}
