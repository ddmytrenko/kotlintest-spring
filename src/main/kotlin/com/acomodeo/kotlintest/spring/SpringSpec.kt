package com.acomodeo.kotlintest.spring

import com.acomodeo.kotlintest.spring.util.AutowireCapableBeanFactoryHolder
import io.kotlintest.Spec

/**
 * @author Mischa Holz
 * @author Dmytro Dmytrenko
 */
interface SpringSpec {
    fun interceptSpringSpec(context: Spec) {
        // implement if needed
    }
}

internal fun SpringSpec.autowireAndInterceptSpec(context: Spec) {
    AutowireCapableBeanFactoryHolder.factory.autowireBean(this)
    interceptSpringSpec(context)
}
