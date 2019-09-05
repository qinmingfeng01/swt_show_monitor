package com.dtg.swt_monitor.buried.utils;

import com.dtg.swt_monitor.buried.entity.MyFile;
import com.dtg.swt_monitor.buried.service.SomprehensiveService;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.File;

/**
 * @program: swt_monitor
 * @description: 文件监听器
 * @author: xiaozhile
 * @create: 2019-07-10 10:40
 **/
public class MyFileListener extends FileAlterationListenerAdaptor {
    private static Logger logger = LoggerFactory.getLogger(MyFileListener.class);
    private String id = CommonUtil.getCommonId();
    private String ip = ComputerMainInfoUtil.getIpAddr();
    private SomprehensiveService somprehensiveService = new SomprehensiveService();

    public MyFileListener(SomprehensiveService somprehensiveService) {
        this.somprehensiveService = somprehensiveService;
    }

    /**
     * 目录发生变化
     * @param directory
     */
    @Override
    public void onDirectoryChange(File directory) {
        super.onDirectoryChange(directory);
        String fileType = "文件夹";
        String statusType = "修改";
        String jdPath = directory.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("文件夹改变:" +directory.getAbsolutePath());
    }

    /**
     * 新建目录
     * @param directory
     */
    @Override
    public void onDirectoryCreate(File directory) {
        super.onDirectoryCreate(directory);
        String fileType = "文件夹";
        String statusType = "新建";
        String jdPath = directory.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("新建目录:" +directory.getAbsolutePath());
    }

    /**
     * 删除目录
     * @param directory
     */
    @Override
    public void onDirectoryDelete(File directory) {
        super.onDirectoryDelete(directory);
        String fileType = "文件夹";
        String statusType = "删除";
        String jdPath = directory.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("删除目录:" +directory.getAbsolutePath());
    }

    /**
     * 文件发生变化
     * @param file
     */
    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
        String fileType = "文件";
        String statusType = "修改";
        String jdPath = file.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("修改文件:" +file.getAbsolutePath());
    }

    /**
     * 新建文件
     * @param file
     */
    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        String fileType = "文件";
        String statusType = "新建";
        String jdPath = file.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("新建文件:"+file.getAbsolutePath());
    }

    /**
     * 删除文件
     * @param file
     */
    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
        String fileType = "文件";
        String statusType = "删除";
        String jdPath = file.getAbsolutePath();
        if(jdPath != null){
            MyFile myFile = new MyFile(id,ip,fileType,statusType,jdPath);
            somprehensiveService.saveMyFile(myFile);
        }

        logger.info("删除文件:" +file.getAbsolutePath());
    }

    /**
     * 文件检查开始
     * @param observer
     */
    @Override
    public void onStart(FileAlterationObserver observer) {
        super.onStart(observer);
        logger.info("开始检查...");
    }

    @Override
    public void onStop(FileAlterationObserver observer) {
        super.onStop(observer);
        logger.info("结束检查...");
    }


}
