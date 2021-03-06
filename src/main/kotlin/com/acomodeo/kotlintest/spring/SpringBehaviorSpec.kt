package com.acomodeo.kotlintest.spring

import com.acomodeo.kotlintest.spring.runner.KotlinTestSpringRunner
import io.kotlintest.Spec
import io.kotlintest.specs.BehaviorSpec
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Mischa Holz
 * @author Dmytro Dmytrenko
 */
@RunWith(KotlinTestSpringRunner::class)
abstract class SpringBehaviorSpec : BehaviorSpec(), SpringSpec {

    override val oneInstancePerTest: Boolean = false

    final override fun interceptSpec(context: Spec, spec: () -> Unit) {
        autowireAndInterceptSpec(context)
        spec()
    }

    @Test
    fun dummyTest() {
        // the dummy test needed for JUnit
    }
}
