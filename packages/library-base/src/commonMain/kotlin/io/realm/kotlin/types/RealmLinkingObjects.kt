/*
 * Copyright 2022 Realm Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.realm.kotlin.types

import io.realm.kotlin.internal.RealmLinkingObjectsImpl
import io.realm.kotlin.query.RealmResults
import kotlin.reflect.KClass
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1

// TODO document
public fun <T : RealmObject> linkingObjects(targetProperty: KProperty1<T, *>, clazz: KClass<T>): RealmLinkingObjects<T> =
    RealmLinkingObjectsImpl(targetProperty, clazz)

// TODO document
public inline fun <reified T : RealmObject> linkingObjects(targetProperty: KProperty1<T, *>): RealmLinkingObjects<T> =
    linkingObjects(targetProperty, T::class)

// TODO document
public interface RealmLinkingObjects<T : RealmObject> {
    public operator fun getValue(reference: RealmObject, referenceProperty: KProperty<*>): RealmResults<T>
}
