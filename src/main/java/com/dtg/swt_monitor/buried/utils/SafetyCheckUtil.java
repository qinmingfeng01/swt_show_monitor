package com.dtg.swt_monitor.buried.utils;

import com.dtg.swt_monitor.buried.entity.SafetyCheck;
import com.dtg.swt_monitor.buried.entity.SafetyCheckDetail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: swt_monitor
 * @description: 安全检查工具类
 * @author: xiaozhile
 * @create: 2019-07-10 16:30
 **/
public class SafetyCheckUtil {
    /**
     * 获取指定路径下的文件名
     * path-路径
     * pFlag-文件类型
     */
    public List<String> getFileListByPath(String path, String pFlag){
        List<String> list = new ArrayList<>();
        File file = new File(path);
        File[] fileList = file.listFiles();
        for (int i = 0;i<fileList.length;i++){
            if (fileList[i].isFile()) {
                String fileName = fileList[i].getName();
                if("0".equals(pFlag)){
                    if(fileName.endsWith("log") && fileName.length()==18){
                        System.out.println("fileName = " + fileName);
                        list.add(fileName);
                    }
                }else if("1".equals(pFlag)){
                    if(fileName.endsWith("log") && fileName.length()==23){
                        System.out.println("fileName = " + fileName);
                        list.add(fileName);
                    }
                }

            }
        }
        return list;
    }

    /**
     * 读取一个文件的内容
     */
    public static List<String> readFileContent(String path){
        List<String> list = new ArrayList<String>();
        try{
            File file = new File(path);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = null;
            while((s = bufferedReader.readLine()) != null){//使用readLine方法，一次读一行
                String rowText = s;
                list.add(rowText);
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取一个指定文件的内容--方法02
     * @param path
     * @return
     */
    public static String readFileContent02(String path){
        String allText = "";
        try{
            File file = new File(path);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file),"GBK");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = null;
            while((s = bufferedReader.readLine()) != null){//使用readLine方法，一次读一行
                String rowText = s+"xzljk";
                allText += rowText;
            }
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allText;
    }

    /**
     * 获取360安全检查日志
     * 20190710111521.log
     */
    public static List<SafetyCheck> getSafetyChecks(){
        List<SafetyCheck> list = new ArrayList<>();

        String fileP = "C:\\Users\\Administrator\\Desktop\\20190710111521.log";
        String text = readFileContent02(fileP);
        String[] split = text.split("----------------------");
        String sp01 = split[0];
        String sp02 = split[1];
        String sp03 = split[2];
        String [] spChild01 = sp01.replace("xzljkxzljk","xzljk").split("xzljk");
        String [] spChild02 = sp02.replace("xzljkxzljk","xzljk").split("xzljk");
        String [] spChild03 = sp03.replace("xzljkxzljk","xzljk").split("xzljk");
        String id = CommonUtil.getCommonId();
        String ip = ComputerMainInfoUtil.getIpAddr();
        String scanTime = spChild01[2];
        String useTime = spChild01[3];
        String scanType = spChild01[4];
        String scanTotalFileCount = spChild01[5];
        String prodectTotalNuM = spChild01[6];
        String clearCount = spChild01[7];

        String isScanAll = spChild02[1];//是否扫描所有文件
        String isScanCompressPackge = spChild02[2];//是否扫描压缩包
        String processType = spChild02[3];//处理方式：由用户选择处理
        String isScanHardDisc = spChild02[4];//是否扫描硬盘
        String isScanRootkit = spChild02[5];
        String isYunchaKill = spChild02[6];//是否使用云查杀
        String isRepair = spChild02[8];//是否建议修复项
        String ConventionalEngines = spChild02[9];//常规引擎

        for (int i=1;i<spChild03.length-2;i++){
            String scanContent = spChild03[i];
            SafetyCheck safetyCheck = new SafetyCheck(id,ip,scanTime,useTime,scanType,scanTotalFileCount,prodectTotalNuM,clearCount,isScanAll,isScanCompressPackge,processType,isScanHardDisc,isScanRootkit,isYunchaKill,isRepair,ConventionalEngines,scanContent);
            list.add(safetyCheck);
        }

        return list;
    }

    /**
     * 获取360检查日志详情
     * 2019-07-10-08-59-00.log
     */
    public static List<SafetyCheckDetail> getSafetyCheckDetils(){
        List<SafetyCheckDetail> list = new ArrayList<>();
        String fileP = "C:\\Users\\Administrator\\Desktop\\2019-07-10-08-59-00.log";
        String id = CommonUtil.getCommonId();
        String ip = ComputerMainInfoUtil.getIpAddr();
        List<String> textList = readFileContent(fileP);
        for (int i=0;i<textList.size();i++){
            String rowText = textList.get(i);
            String [] split = rowText.split(";");
            int splitLength = split.length;
            String zeroID = "";
            String pid = "";
            String processName = "";
            String runTime = "";
            String processPath = "";
            String processPathIsSafety = "";
            if (splitLength == 6){
                zeroID = split[0];
                pid = split[1];
                processName = split[2];
                runTime = split[3];
                processPath = split[4];
                processPathIsSafety = split[5];
            }else if (splitLength == 5){
                zeroID = split[0];
                pid = split[1];
                processName = split[2];
                runTime = split[3];
                processPath = split[4];
                processPathIsSafety = "";
            }
            SafetyCheckDetail safetyCheckDetail = new SafetyCheckDetail(id,ip,zeroID,pid,processName,runTime,processPath,processPathIsSafety);
            list.add(safetyCheckDetail);
        }
        return list;
    }
}
