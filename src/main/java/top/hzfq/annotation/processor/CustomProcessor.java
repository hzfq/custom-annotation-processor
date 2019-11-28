package top.hzfq.annotation.processor;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;

/**
 * 自定义注解处理器
 *
 * @author hzfq
 * @email huzhifengqing@qq.com
 * @date 2019/11/27
 */
@SupportedAnnotationTypes("top.hzfq.annotation.CustomAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //具体处理注解的逻辑
        try {
            File file = new File("D:/temp/anno.txt");
            FileWriter fw = new FileWriter(file);
            fw.append(roundEnv.toString());

            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
