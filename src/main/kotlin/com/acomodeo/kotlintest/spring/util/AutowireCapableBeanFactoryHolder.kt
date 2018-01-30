package com.acomodeo.kotlintest.spring.util

import com.acomodeo.kotlintest.spring.annotation.JvmNotFinal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.AutowireCapableBeanFactory

/**
 * @author Mischa Holz
 * @author Dmytro Dmytrenko
 */
@JvmNotFinal
class AutowireCapableBeanFactoryHolder {

    @Autowired
    fun autowireFactory(factory: AutowireCapableBeanFactory) {
        Companion.factory = factory
    }

    companion object {
        lateinit var factory: AutowireCapableBeanFactory
    }
}
