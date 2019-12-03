package cn.liuc.activitidemo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import cn.liuc.activitidemo.service.ExportExcelService;
import cn.liuc.activitidemo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2019/11/16 14:28
 */
@RestController
@RequestMapping(value = "/v1")
public class HealthController {

    @Autowired
    ExportExcelService exportExcelService;

    @GetMapping("/health")
    public String health() {
        return "ok";
    }

    @GetMapping("/user/download")
    public void exportUser(HttpServletResponse response,
                           @RequestParam String name,
                           @RequestParam int age) throws IOException {
        String fileName = "user_download_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        List<UserVo> list = data(name, age, "测试写入Excel");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        try {
//            ExcelUtil.exportExcel(response.getOutputStream(),"用户下载", UserVo.class, list);
            exportExcelService.exportExcel(response);
        } catch (IOException e) {
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(map);
        }
    }

    private List<UserVo> data(String name, int age, String content) {
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserVo data = new UserVo();
            data.setName(name+i);
            data.setAge(age+i);
            data.setContent(content+"----"+i);
            list.add(data);
        }
        return list;
    }
}
