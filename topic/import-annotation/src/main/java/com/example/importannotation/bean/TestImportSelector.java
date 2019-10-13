package com.example.importannotation.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Import 作用3：导入ImportSelector的实现类
 *
 * @author: yinxing
 * @date: 2019/10/13
 */
public class TestImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 类的全限定名
        return new String[]{"com.example.importannotation.bean.TestBean3"};
    }
}
