package com.dtg.swt_monitor.buried.utils;

import com.dtg.swt_monitor.buried.entity.CpuInfos;
import com.dtg.swt_monitor.buried.entity.OprateSys;
import org.hyperic.sigar.*;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: swt_monitor
 * @description: 电脑信息概览工具类
 * @author: xiaozhile
 * @create: 2019-07-10 10:37
 **/
public class ComputerMainInfoUtil {
    private static Sigar sigar = new Sigar();

    /**
     * 1.获取操作系统名称
     * @return
     */
    public static String getOprateSysName() {
        String hostname = "";
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (Exception exc) {
            //Sigar sigar = new Sigar();
            try {
                hostname = sigar.getNetInfo().getHostName();
            } catch (SigarException e) {
                hostname = "localhost.unknown";
            } finally {
                sigar.close();
            }
        }
        return hostname;
    }

    /**
     * 2.获取操作系统详细信息
     * @return
     */
    public static OprateSys getOperateSystemInfo(){
        OperatingSystem OS = OperatingSystem.getInstance();

        String id = CommonUtil.getCommonId();
        String ip = ComputerMainInfoUtil.getIpAddr();
        String oprateSysName = ComputerMainInfoUtil.getOprateSysName();
        String arch = OS.getArch();
        String dataModel = OS.getDataModel();
        String description = OS.getDescription();
        String vendor = OS.getVendor();
        String vendorCodeName = OS.getVendorCodeName();
        String vendorName = OS.getVendorName();
        String version = OS.getVersion();
        OprateSys oprateSys = new OprateSys(id,ip,oprateSysName,arch,dataModel,description,vendor,vendorCodeName,vendorName,version);
        return oprateSys;
        // 操作系统内核类型如： 386、486、586等x86
        /*System.out.println("OS.getArch() = " + OS.getArch());
        System.out.println("OS.getCpuEndian() = " + OS.getCpuEndian());//
        System.out.println("OS.getDataModel() = " + OS.getDataModel());//
        // 系统描述
        System.out.println("OS.getDescription() = " + OS.getDescription());
        System.out.println("OS.getMachine() = " + OS.getMachine());//
        // 操作系统类型
        System.out.println("OS.getName() = " + OS.getName());
        System.out.println("OS.getPatchLevel() = " + OS.getPatchLevel());//
        // 操作系统的卖主
        System.out.println("OS.getVendor() = " + OS.getVendor());
        // 卖主名称
        System.out.println("OS.getVendorCodeName() = " + OS.getVendorCodeName());
        // 操作系统名称
        System.out.println("OS.getVendorName() = " + OS.getVendorName());
        // 操作系统卖主类型
        System.out.println("OS.getVendorVersion() = " + OS.getVendorVersion());
        // 操作系统的版本号
        System.out.println("OS.getVersion() = " + OS.getVersion());*/
    }

    /**
     * 3.获取当前电脑的ip
     * @return
     */
    public static String getIpAddr() {
        String ip = null;
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
            // 没有出现异常而正常当取到的IP时，如果取到的不是网卡循回地址时就返回
            // 否则再通过Sigar工具包中的方法来获取
            if (!NetFlags.LOOPBACK_ADDRESS.equals(ip)) {
                return ip;
            }
        } catch (Exception e) {
            // hostname not in DNS or /etc/hosts
        }
        Sigar sigar = new Sigar();
        try {
            ip = sigar.getNetInterfaceConfig().getAddress();
        } catch (SigarException e) {
            ip = NetFlags.LOOPBACK_ADDRESS;
        } finally {
            sigar.close();
        }
        return ip;
    }

    /**
     * 4.获取当前电脑的mac
     * @return
     */
    public static String getMAC() {
        Sigar sigar = null;
        try {
            sigar = new Sigar();
            String[] ifaces = sigar.getNetInterfaceList();
            String hwaddr = null;
            for (int i = 0; i < ifaces.length; i++) {
                NetInterfaceConfig cfg = sigar.getNetInterfaceConfig(ifaces[i]);
                if (NetFlags.LOOPBACK_ADDRESS.equals(cfg.getAddress()) || (cfg.getFlags() & NetFlags.IFF_LOOPBACK) != 0 || NetFlags.NULL_HWADDR.equals(cfg.getHwaddr())) {
                    continue;
                }
                /*
                 * 如果存在多张网卡包括虚拟机的网卡，默认只取第一张网卡的MAC地址，如果要返回所有的网卡（包括物理的和虚拟的）则可以修改方法的返回类型为数组或Collection
                 * ，通过在for循环里取到的多个MAC地址。
                 */
                hwaddr = cfg.getHwaddr();
                break;
            }
            return hwaddr != null?hwaddr : null;
        } catch (Exception e) {
            return null;
        } finally {
            if (sigar != null)
                sigar.close();
        }
    }

    /**
     * 5.获取当前电脑cpu的详细信息
     * @return
     * @throws SigarException
     */
    public static List<CpuInfos> getCpuInfos() throws SigarException {
        List<CpuInfos> list = new ArrayList();
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpuList[] = null;
        cpuList = sigar.getCpuPercList();
        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
            CpuInfo info = infos[i];
            CpuInfos cpuInfos = new CpuInfos();
            String id = CommonUtil.getCommonId();
            String ip = ComputerMainInfoUtil.getIpAddr();
            cpuInfos.setId(id);
            cpuInfos.setIp(ip);
            cpuInfos.setErrorCupRate(CpuPerc.format(cpuList[i].getNice()));
            cpuInfos.setCpuBindCount(cpuList[i].getCombined()+"");
            cpuInfos.setCpuMhz(info.getMhz()+"");
            cpuInfos.setUseRate(CpuPerc.format(cpuList[i].getUser()));
            cpuInfos.setFreeRate(CpuPerc.format(cpuList[i].getIdle()));
            cpuInfos.setCpuType(info.getModel());
            cpuInfos.setCpuVendor(info.getVendor());
            cpuInfos.setCacheSize(info.getCacheSize()+"");
            cpuInfos.setCpuSort(i+1+"");
            list.add(cpuInfos);
        }
        return list;
    }

    /**
     * 6.内存相关
     * 6.1 内存总量
     */
    public static String getMemoryCount(){
        Sigar sigar = new Sigar();
        Mem mem;
        try {
            mem = sigar.getMem();
            return mem.getTotal() / 1024L/1024L/1024L + "GB";
        } catch (SigarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "0GB";
    }

    /**
     * 6.内存相关
     * 6.2 当前内存使用量
     */
    public static String getUseMemoryCount(){
        Sigar sigar = new Sigar();
        Mem mem;
        try {
            mem = sigar.getMem();
            return mem.getUsed() / 1024L/1024L/1024 + "GB";
        } catch (SigarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "0GB";
    }

    /**
     * 6.内存相关
     * 6.3 当前内存剩余量
     */
    public static String getFreeMemoryCount(){
        Sigar sigar = new Sigar();
        Mem mem;
        try {
            mem = sigar.getMem();
            return mem.getFree() / 1024L/1024L/1024 + "GB";
        } catch (SigarException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "0GB";
    }
}
