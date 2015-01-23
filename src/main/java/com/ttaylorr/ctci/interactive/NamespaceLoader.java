package com.ttaylorr.ctci.interactive;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NamespaceLoader {
    protected final String namespace;
    protected final ClassLoader loader;

    public NamespaceLoader(String namespace) {
        this.namespace = namespace;
        this.loader = this.getClass().getClassLoader();
    }

    public List<Class<?>> load() {
        List<Class<?>> loaded = new ArrayList<>();

        for (File fd : this.getClassDirectory().listFiles()) {
            try {
                loaded.addAll(this.processFileOrDirectory(fd));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return loaded;
    }

    private List<Class<?>> processFileOrDirectory(File f) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();

        if (f.isDirectory()) {
            for (File file : f.listFiles()) {
                classes.addAll(this.processFileOrDirectory(file));
            }
        } else {
            classes.add(this.loader.loadClass(this.getClassnameFromFile(f)));
        }

        return classes;
    }

    private String getRoot() {
        return this.loader.getResource("").getPath();
    }

    private String getClassnameFromFile(File f) {
        String path = f.getAbsolutePath();

        return path.substring(path.indexOf("com/")) // Remove everything that we don't need
                   .replace(".class", "") // Remove the trailing ".class" extension
                   .replace("/", "."); // Change the file separators to namespace delimiters
    }

    private File getClassDirectory() {
        return new File(this.getRoot(), "/" + this.namespace.replace(".", "/") + "/");
    }
}
