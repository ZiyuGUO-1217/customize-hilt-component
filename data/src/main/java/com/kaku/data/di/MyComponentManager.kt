package com.kaku.data.di

import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MyComponentManager @Inject constructor(
    private val componentProvider: Provider<MyComponentBuilder>,
) : GeneratedComponentManager<MyComponent> {

    @Volatile
    private var myComponent: MyComponent? = null

    private val componentLock = Any()

    fun recreateComponent() {
        myComponent = createComponent()
    }

    override fun generatedComponent(): MyComponent {
        if (myComponent == null) {
            synchronized(componentLock) {
                if (myComponent == null) {
                    myComponent = createComponent()
                }
            }
        }

        return myComponent!!
    }

    private fun createComponent() = componentProvider.get().build()
}
