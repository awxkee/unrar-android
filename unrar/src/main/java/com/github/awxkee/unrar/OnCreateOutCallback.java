package com.github.awxkee.unrar;

import java.io.IOException;

public interface OnCreateOutCallback {
    UnrarCallback createOut(String entryName) throws IOException;
}
