package com.dtg.swt_monitor.buried.controller;

import com.dtg.swt_monitor.buried.entity.*;
import com.dtg.swt_monitor.buried.service.SomprehensiveService;
import com.dtg.swt_monitor.buried.utils.*;
import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @program: swt_monitor
 * @description: 综合业务层
 * @author: xiaozhile
 * @create: 2019-07-10 17:42
 **/
@Controller
@RequestMapping(value = "/somprehensiveController")
public class SomprehensiveController {
    @Resource
    private SomprehensiveService somprehensiveService;
    private static Logger logger = LoggerFactory.getLogger(SomprehensiveController.class);

    /**
     * 测试
     */
    @RequestMapping(value = "/ceShiJinCheng")
    @ResponseBody
    public void ceShiJinCheng() throws Exception{

    }

    /**
     * 1.进程入库
     */
    @RequestMapping(value = "/saveComputerProcess")
    @ResponseBody
    public String saveComputerProcess(){
        int saveFlag = somprehensiveService.saveComputerProcess();
        String result = "进程入库失败！";
        if(saveFlag != 0){
            result = "进程入库成功";
        }
        return result;
    }

    /**
     * 2.CPU入库
     */
    @RequestMapping(value = "/saveCpu")
    @ResponseBody
    public String saveCpu(){
        int saveFlag = somprehensiveService.saveCpuInfos();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }

    /**
     * 3.硬盘入库
     */
    @RequestMapping(value = "/saveHardDisk")
    @ResponseBody
    public String saveHardDisk(){
        int saveFlag = somprehensiveService.saveHardDisc();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }

    /**
     * 内存入库
     */
    @RequestMapping(value = "/saveMenory")
    @ResponseBody
    public String saveMenory(){
        int saveFlag = somprehensiveService.saveMemory();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }

    /**
     * 文件监听入库
     */
    @RequestMapping(value = "/saveMyfile")
    @ResponseBody
    public void saveMyfile(){
        long interval = 1000;
        final String path = "D:\\监控测试";
        FileAlterationObserver observer = null;
        try{
            observer = new FileAlterationObserver(path,null,null);
            //添加监听器
            observer.addListener(new MyFileListener(somprehensiveService));

            FileAlterationMonitor monitor = new FileAlterationMonitor(interval,observer);
            monitor.start();
        }catch (Exception e){
            logger.error("Exception ", e);
        }
    }

    /**
     * 操作系统入库
     */
    @RequestMapping(value = "/saveOprateSys")
    @ResponseBody
    public String saveOprateSys(){
        int saveFlag = somprehensiveService.saveOprateSys();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }

    /**
     * 360安全检查日志入库
     */
    @RequestMapping(value = "/saveSafetyCheck")
    @ResponseBody
    public String saveSafetyCheck(){
        int saveFlag = somprehensiveService.saveSafetyCheck();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }

    /**
     * 360安全检查日志详情入库
     */
    @RequestMapping(value = "/saveSafetyCheckDetail")
    @ResponseBody
    public String saveSafetyCheckDetail(){
        int saveFlag = somprehensiveService.saveSafetyCheckDetail();
        String result = "入库失败！";
        if(saveFlag != 0){
            result = "入库成功";
        }
        return result;
    }


}
