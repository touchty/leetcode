package basics;

import java.io.*;
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
        String classToFind = "WordBreakII";
        MyFileSystemClassLoader loader = new MyFileSystemClassLoader(rootDir);
        try {
            Class myClass = loader.findClass(classToFind);
            System.out.println(myClass.getName());
            /*Class<WordBreakII> c = myClass;
            WordBreakII nm = c.newInstance();*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}