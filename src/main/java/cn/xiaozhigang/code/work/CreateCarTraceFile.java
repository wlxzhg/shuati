package cn.xiaozhigang.code.work;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreateCarTraceFile {

    public static void main(String[] args) throws Exception {
        String basePath = "D://项目//CarTrace-Work//车辆";
        String originalFileName,targetFileName;
        int fileNum = 1;
        for(int start = 21; start < 3200; start++) {
            String fileNumStr = ((fileNum < 10)?"00":"0") + fileNum;
            String targetFileNumStr = ((start < 100)?"0":"") + start;

            originalFileName = basePath + "//" + fileNumStr;

            targetFileName = basePath + "//" + targetFileNumStr;
            Path targetPath = Paths.get(targetFileName);
            Path originalPath = Paths.get(originalFileName);

//            Files.createDirectories(targetPath);
//            Files.copy(originalPath.resolve(fileNumStr + ".txt"), targetPath.resolve(targetFileNumStr + ".txt"));
//            Files.copy(originalPath.resolve(fileNumStr + ".jpg"), targetPath.resolve(targetFileNumStr + ".jpg"));
            List<String> infos = Files.readAllLines(targetPath.resolve(targetFileNumStr + ".txt"), Charset.forName("GBK"));

            infos.set(0, targetFileNumStr);
            System.out.println(infos.get(0));

            Files.write(targetPath.resolve(targetFileNumStr + ".txt"), infos, Charset.forName("GBK"));


            fileNum = (fileNum == 20) ? 1 : fileNum + 1;
        }
    }
}