package com.example.controller;

import com.example.common.Result;
import com.example.entity.Records;
import com.example.service.RecordsService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * 收支明细前端操作接口
 **/
@RestController
@RequestMapping("/records")
public class RecordsController {

    @Resource
    private RecordsService recordsService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Records records) {
        recordsService.add(records);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        recordsService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        recordsService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody Records records) {
        recordsService.updateById(records);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        Records records = recordsService.selectById(id);
        return Result.success(records);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(Records records) {
        List<Records> list = recordsService.selectAll(records);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(Records records,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<Records> page = recordsService.selectPage(records, pageNum, pageSize);
        return Result.success(page);
    }

}