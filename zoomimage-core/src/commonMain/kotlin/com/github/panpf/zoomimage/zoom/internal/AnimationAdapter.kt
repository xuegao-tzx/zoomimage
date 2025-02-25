/*
 * Copyright (C) 2024 panpf <panpfpanpf@outlook.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.panpf.zoomimage.zoom.internal

import com.github.panpf.zoomimage.util.OffsetCompat
import com.github.panpf.zoomimage.util.RectCompat
import com.github.panpf.zoomimage.zoom.BaseZoomAnimationSpec

interface AnimationAdapter {

    suspend fun startAnimation(
        animationSpec: BaseZoomAnimationSpec?,
        onProgress: (progress: Float) -> Unit,
        onEnd: () -> Unit
    )

    suspend fun stopAnimation(): Boolean

    suspend fun startFlingAnimation(
        startUserOffset: OffsetCompat,
        userOffsetBounds: RectCompat?,
        velocity: OffsetCompat,
        extras: Map<String, Any>,
        onUpdateValue: (value: OffsetCompat) -> Boolean,
        onEnd: () -> Unit = {}
    )

    suspend fun stopFlingAnimation(): Boolean
}