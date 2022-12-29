package com.github.awxkee.unrar;

import androidx.annotation.Keep;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

@Keep
public interface UnrarCallback extends Closeable {
    @Keep
    void processData(ByteBuffer buffer, int len) throws IOException;

    //TODO 分卷解压监听
}
