package com.kaku.data.di

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

// Types scoped to this component must be annotated with @MyScope
@MyScope
// Make MyComponent subcomponent of ApplicationComponent
@DefineComponent(parent = SingletonComponent::class)
interface MyComponent


// Builder to create instances of MyComponent
@DefineComponent.Builder
interface MyComponentBuilder {
    // can set something here
    // fun setUser(@BindsInstance user: String): Builder
    fun build(): MyComponent
}
