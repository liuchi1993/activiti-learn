package cn.liuc.activitidemo.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Date: 2019/12/2 20:54
 */
public class UserVo {
    @ExcelProperty("用户姓名")
    private String name;
    @ExcelProperty("用户年龄")
    private int age;
    @ExcelIgnore
    private int isDelete;

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
    @ExcelProperty("备注")
    private String content;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
