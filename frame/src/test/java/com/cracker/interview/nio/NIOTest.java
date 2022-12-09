package com.cracker.interview.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

import static com.cracker.interview.nio.imports.ByteBufferUtil.debugAll;

@Slf4j
class NIOTest {
    
    @Test
    void channelTest1() {
        try(RandomAccessFile file = new RandomAccessFile("src/test/resources/data.txt", "rw")) {
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(10);
            do {
                int len = channel.read(buffer);
                log.debug("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                buffer.flip();
                while (buffer.hasRemaining()) {
                    log.debug("{}", (char)buffer.get());
                }
                buffer.clear();
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    void ByteBufferAndStringInterchangeTest() {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        debugAll(buffer);

        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("hello");
        debugAll(buffer1);

        ByteBuffer buffer2 = ByteBuffer.wrap("hello".getBytes());
        debugAll(buffer2);

        String string = StandardCharsets.UTF_8.decode(buffer2).toString();
        System.out.println(string);

        buffer.flip();
        String str2 = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str2);
    }
    
    @Test
    void byteBufferErrorPacketHandlingTest() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(buffer);
        buffer.put("w are you?\n".getBytes());
        split(buffer);
    }

    private static void split(final ByteBuffer buffer) {
        buffer.flip();
        for (int i = 0; i < buffer.limit(); i++) {
            if (buffer.get(i) == '\n') {
                int len = i + 1 - buffer.position();
                ByteBuffer temp = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    temp.put(buffer.get());
                }
                debugAll(temp);
            }
        }
        buffer.compact();
    }
}
