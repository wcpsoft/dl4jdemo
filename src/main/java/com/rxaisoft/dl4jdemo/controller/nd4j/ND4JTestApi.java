package com.rxaisoft.dl4jdemo.controller.nd4j;

import org.nd4j.jita.conf.CudaEnvironment;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/nd4j")
public class ND4JTestApi {

    private Logger logger = LoggerFactory.getLogger(ND4JTestApi.class);

    @GetMapping("/test")
    public Map<String, Object> test() {
        CudaEnvironment.getInstance().getConfiguration()
                .allowMultiGPU(false)
                .setMaximumDeviceCache(11L * 1024L * 1024L * 1024L)
                .allowCrossDeviceAccess(true);
        Map<String, Object> result = new HashMap<String, Object>();
        logger.info(Nd4j.getBackend().toString());
        INDArray tensor1 = Nd4j.create(new double[]{1,2,3});
        INDArray tensor2 = Nd4j.create(new double[]{10.0,20.0,30.0});
        long startTime = System.currentTimeMillis();
        INDArray sum = tensor1.add(tensor2);
        double[] sumArray = sum.toDoubleVector();
        long endTime = System.currentTimeMillis() - startTime;
        result.put("sum", sumArray);
        result.put("take-up-time", endTime);
        return result;
    }
}
