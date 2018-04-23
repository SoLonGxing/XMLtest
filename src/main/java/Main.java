import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws DocumentException {

        System.out.println("Hello World!");

        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = reader.read(new File("src/file/example.xml"));
        //获取根节点元素对象
        Element rootElement = document.getRootElement();

        Element privateElement = rootElement.element("PRIVATE");

        Element recordsElement = privateElement.element("RECORDS");

        List<Element> recordList = recordsElement.elements("RECORD");
        for(Element listElement : recordList){
            String rId = listElement.element("RID").getText();
            String rName = listElement.element("RNAME").getText();
            System.out.println("rId =" + rId);
            System.out.println("rName =" + rName);
        }
    }
}
