/*
 * Copyright 2011 Henry Coles
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class SafeDataOutputStream {

  private final DataOutputStream dos;

  public SafeDataOutputStream(final OutputStream os) {
    this.dos = new DataOutputStream(os);
  }

  public void writeInt(final int value) {
    try {
      this.dos.writeInt(value);
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public void writeString(final String str) {
    try {
      final byte[] data = str.getBytes("UTF-8");
      this.dos.writeInt(data.length);
      this.dos.write(data);

    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public <T> void write(final T value) {
    writeString(IsolationUtils.toXml(value));
  }

  public void flush() {
    try {
      this.dos.flush();
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public void close() {
    try {
      this.dos.close();
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public void writeByte(final byte b) {
    try {
      this.dos.writeByte(b);
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public void writeBoolean(final boolean b) {
    try {
      this.dos.writeBoolean(b);
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

  public void writeLong(final long l) {
    try {
      this.dos.writeLong(l);
    } catch (final IOException e) {
      throw Unchecked.translateCheckedException(e);
    }
  }

}
