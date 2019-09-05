package com.dtg.swt_monitor.buried.utils;

import com.dtg.swt_monitor.buried.entity.HardDisc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: swt_monitor
 * @description: 硬盘工具类
 * @author: xiaozhile
 * @create: 2019-07-10 10:39
 **/
public class HardDiscJkUtil {
    public static List<HardDisc> getHardDiscInfos() throws Exception{
        List<HardDisc> list = new ArrayList<HardDisc>();
        Sigar sigar = new Sigar();
        FileSystem fslist [] = sigar.getFileSystemList();
        //当前用户的文件夹路径
        String dir = System.getProperty("user.home");
        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            FileSystemUsage usage = null;
            try {
                usage = sigar.getFileSystemUsage(fs.getDirName());
            } catch (SigarException e) {
                if (fs.getType() == 2)
                    throw e;
                continue;
            }
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘	                    // 文件系统总大小
                    String id = CommonUtil.getCommonId();
                    String ip = ComputerMainInfoUtil.getIpAddr();
                    String usePercent = usage.getUsePercent() * 100D+"";
                    HardDisc hardDisc = new HardDisc();
                    hardDisc.setId(id);
                    hardDisc.setIp(ip);
                    hardDisc.setUseAmount(usage.getUsed() / 1024L/1024L + "GB");
                    hardDisc.setUseRate(usePercent);
                    hardDisc.setSysTypeName(fs.getSysTypeName());
                    hardDisc.setTotalAmount(usage.getTotal() /1024L/1024L+ "GB");
                    hardDisc.setDevName(fs.getDevName());
                    hardDisc.setFreeAmount(usage.getFree()/ 1024L/1024L + "GB");
                    list.add(hardDisc);
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
        }

        return list;
    }
}
