package com.example.controller;

import com.example.common.Result;
import com.example.entity.Certification;
import com.example.service.CertificationService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 前端操作接口
 **/
@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Resource
    private CertificationService certificationService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Certification certification) {
        certificationService.add(certification);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        certificationService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        certificationService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Certification certification) {
        certificationService.updateById(certification);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Certification certification = certificationService.selectById(id);
        return Result.success(certification);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Certification certification) {
        List<Certification> list = certificationService.selectAll(certification);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Certification certification,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Certification> page = certificationService.selectPage(certification, pageNum, pageSize);
        return Result.success(page);
    }

    /**
     * 查询当前用户的认证信息
     */
    @GetMapping("/selectUserCertification")
    public Result selectUserCertification() {
        Certification certification = certificationService.selectUserCertification();
        return Result.success(certification);
    }

}