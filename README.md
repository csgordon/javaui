GUI Effects Checker
===================
This repository contains a prototype implementation of a Java effect system to ensure the absence
of threading access errors from accessing UI objects from threads other than the UI event loop
thread.

<b>This is an archival version of the code, corresponding to the ECOOP'13 paper mentioned below.</b>

<b>The current version has been incorporated into the <a href="http://types.cs.washington.edu/checker-framework/current/checker-framework-manual.html#guieffect-checker">Checker
Framework</a>.</b>

Methods that access GUI objects are assigned the *UI effect*.  Methods that do not access such
objects are given the *Safe effect*, and methods annotated as safe are not permitted to call methods
with the UI effect.

Of course, things get a bit more complicated with polymorphism.

ECOOP 2013 Paper
----------------
JavaUI is described in detail in an ECOOP 2013 paper titled
"JavaUI: Effects for Controlling UI Object Access."
The paper and extended technical report are available from
the first author's [homepage](http://homes.cs.washington.edu/~csgordon).

The annotated subject programs are available:

* EclipseRunner: https://bitbucket.org/csgordon/eclipserunner
* HudsonEclipse: https://bitbucket.org/csgordon/hudson-eclipse
* S3dropbox: https://bitbucket.org/csgordon/s3dropbox
* SudokuSolver: https://bitbucket.org/csgordon/sudoku-solver
* Eclipse Color Theme: https://bitbucket.org/csgordon/eclipse-color-theme
* LogViewer: https://bitbucket.org/csgordon/logviewer
* JVMMonitor: https://bitbucket.org/csgordon/jvmmonitor
* Subclipse: https://bitbucket.org/csgordon/subclipse

The subject programs were checked against Eclipse 3.7 on Ubuntu 12.10, and the scripts to run JavaUI
over the subject programs hard-code paths to relevant JARs.

Implementation
--------------
The type system is built on top of the Checker Framework (http://types.cs.washington.edu).  It
includes a few annotations:

* @UIEffect: a method annotation indicating the method's effect is UI
* @SafeEffect: a method annotation indicating the method's effect is Safe (this is the default for
  unannotated methods, unless the default is overridden by a type or package annotation)
* @UIType: a type declaration annotation (class, interface) annotation that makes all methods contained within have the UI
  effect
* @UIPackage: like @UIType, but for packages

There are also type qualifiers and additional annotations to support polymorphism:

* @UI: a type qualifier to instantiate effect-generic types with the UI effect
* @AlwaysSafe: a type qualifier to instantiate effect-generic types with the Safe effect
* @PolyUIType: a type declaration (class, interface) annotation declaring that the type may have UI
  and Safe variants, allowing method arguments to be qualified with @PolyUI.  This is often used for
  interfaces like Runnable, which are often used both for tasks run asynchronously on the UI thread
  and for general asynchronous tasks.
* @PolyUI: a type qualifier that refers to the particular instantiation of a generic type
* @PolyUIEffect: a method annotation indicating that the method's effect depends on the
  instantiation of a generic type.

License
-------
This code is licensed under Matt Might's aptly-named CRAPL.  The license is provided in CRAPL-LICENSE.txt in this repository.
For more information on the CRAPL, see Matt Might's article:

<center>http://matt.might.net/articles/crapl/</center>
