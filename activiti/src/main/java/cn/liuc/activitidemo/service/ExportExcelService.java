package cn.liuc.activitidemo.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.liuc.activitidemo.util.DateTimeUtil;
import cn.liuc.activitidemo.util.ExcelUtil;
import cn.liuc.activitidemo.vo.UserFeedbackVo;
import org.springframework.stereotype.Service;

/**
 * @Date: 2019/12/3 21:59
 */
@Service
public class ExportExcelService {

    public void exportExcel(HttpServletResponse response) throws IOException {
        List<UserFeedbackVo> list = genDatalist();
        String[] titles = genTitleList();
        List<List<String>> dataList = new ArrayList<>();
        List<String> rowList;
        for (UserFeedbackVo userFeedbackVo : list) {
            rowList = new ArrayList<>();
            rowList.add(String.valueOf(userFeedbackVo.getId()));
            rowList.add(String.valueOf(userFeedbackVo.getUid()));
            rowList.add(DateTimeUtil.timeStamp2Date(userFeedbackVo.getCreateTime()));
            rowList.add(DateTimeUtil.timeStamp2Date(userFeedbackVo.getUpdateTime()));
            rowList.add(userFeedbackVo.getContent());
            rowList.add(userFeedbackVo.getReply());
            if (userFeedbackVo.getStatus() == 0) {
                rowList.add("未回复");
            } else {
                rowList.add("已回复");
            }
            dataList.add(rowList);
        }
        ExcelUtil.exportExcel(response.getOutputStream(), "用户反馈", titles, dataList);
    }

    private String[] genTitleList() {
        return new String[]{
                "ID",
                "用户ID",
                "创建时间",
                "回复时间",
                "反馈内容",
                "回复内容",
                "状态"
        };
    }

    private List<UserFeedbackVo> genDatalist() {
        List<UserFeedbackVo> list = new ArrayList<>();
        UserFeedbackVo userFeedbackVo;
        for (int i = 0; i < 10; i++) {
            userFeedbackVo = new UserFeedbackVo();
            userFeedbackVo.setId(i);
            userFeedbackVo.setUid(10000 + i);
            userFeedbackVo.setCreateTime(DateTimeUtil.timeStampSecond());
            userFeedbackVo.setUpdateTime(DateTimeUtil.timeStampSecond());
            userFeedbackVo.setContent("test content--------------------------------------" + i);
            userFeedbackVo.setReply("reply ------------" + i);
            userFeedbackVo.setStatus(1);
            list.add(userFeedbackVo);
        }
        return list;
    }
}
