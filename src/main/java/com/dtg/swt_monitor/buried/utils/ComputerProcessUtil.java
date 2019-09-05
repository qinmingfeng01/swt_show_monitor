package com.dtg.swt_monitor.buried.utils;

import com.dtg.swt_monitor.buried.entity.ComputerProcess;
import org.hyperic.sigar.*;
import org.hyperic.sigar.cmd.Ps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: swt_monitor
 * @description: 进程工具类
 * @author: xiaozhile
 * @create: 2019-07-10 10:38
 **/
public class ComputerProcessUtil {

    /**
     * 获取进程
     * @return
     */
    public static List<ComputerProcess> getJinChengList(){
        List<ComputerProcess> processList = new ArrayList<ComputerProcess>();
        String cip = ComputerMainInfoUtil.getIpAddr();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currDate = formatter.format(new Date());
        try{
            Sigar sigarImpl = new Sigar();
            SigarProxy sigarProxy = SigarProxyCache.newInstance(sigarImpl);
            // Shell.clearScreen();
            long[] pids = sigarImpl.getProcList();
            for (int i = 0; i < pids.length; i++) {
                long pid = pids[i];
                String cpuPerc = "?";
                List info;
                try {
                    info = Ps.getInfo(sigarProxy, pid);
                } catch (SigarException e) {
                    continue; //process may have gone away
                }
                try {
                    ProcCpu cpu = sigarProxy.getProcCpu(pid);
                    cpuPerc = CpuPerc.format(cpu.getPercent());
                } catch (SigarException e) {
                }

                info.add(info.size() - 1, cpuPerc);
                ComputerProcess computerProcess = new ComputerProcess();
                computerProcess.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                computerProcess.setIp(cip);
                computerProcess.setCreatetime(currDate);
                computerProcess.fuZhi(info);
                processList.add(computerProcess);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return processList;
    }




}
