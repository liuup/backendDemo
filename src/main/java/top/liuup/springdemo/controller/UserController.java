package top.liuup.springdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import top.liuup.springdemo.dao.Database;
import top.liuup.springdemo.pojo.Brand;

@RestController
@RequestMapping("/tb_brand")
public class UserController {

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("query id is " + id);

        Database database = new Database();
        String text = "";

        try {
            text = database.queryDataById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }


    @PostMapping
    public String save(@RequestBody JSONObject jsonParam) {
        System.out.println("user save...");
        System.out.println(jsonParam);

        Brand brand = JSON.parseObject(String.valueOf(jsonParam), Brand.class);

        System.out.println(brand);

        return "{'module':'user save'}";
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("delete id is " + id);
        return "{'module':'user delete'}";
    }
}
