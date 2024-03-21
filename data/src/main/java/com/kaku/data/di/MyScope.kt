package com.kaku.data.di

import javax.inject.Scope

// Annotation for scoping to UserComponent
@Scope
@MustBeDocumented
@Retention(value = AnnotationRetention.RUNTIME)
annotation class MyScope
