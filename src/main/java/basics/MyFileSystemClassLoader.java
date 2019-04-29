package basics;

import dp.CoinChange;
import dp.Triangle;

import java.io.*;
import java.util.LinkedList;

public class MyFileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public MyFileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String rootDir = "C:\\Users\\touchty\\IdeaProjects\\leetcode\\target\\classes";
        String classToFind = "dp.Triangle";
        MyFileSystemClassLoader loader = new MyFileSystemClassLoader(rootDir);
        try {
            Class<Triangle> myClass = (Class<Triangle>) loader.findClass(classToFind);
            // Triangle v = myClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}