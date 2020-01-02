package com.jizheping.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WriteTxt {
    public static void main(String[] args) throws IOException {
        for(int i=8000;i<9000;i++){
            File file = new File("D:\\yxy\\proj\\ar2\\_ar眼镜15766"+i+".txt");
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(new Date().toString());
            bufferedWriter.newLine();
            bufferedWriter.write("响应信息：{\"latitude\":\"113."+i+"5888\",\"id\":\"2000\",\"state\":1,\"type\":1,\"longitude\":\"34.79252710\"}");
            bufferedWriter.close();
        }

        System.out.println("成功!!!");
    }
}
