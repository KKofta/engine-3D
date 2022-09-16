# Engine 3D

---

## Table of Contents

- [General information](#general-information)
- [Used Technologies](#used-technologies)
- [Imported Files Structure](#imported-files-structure)
- [Screenshots](#screenshots)

---

### General information

The aim of a project was to create an application which would imitate usage of a virtual camera. The implementation consists of various linear algebra operations and computer graphics algorithms.

The following topics were included in the project:

- Representation of a three-dimensional space on a plane;
- Geometric transformations – translations, rotations and zoom;
- Hidden surface elimination – <a href="https://en.wikipedia.org/wiki/Painter%27s_algorithm">Painter's Algorithm</a>;
- Lighting modeling – <a href="https://en.wikipedia.org/wiki/Phong_reflection_model">Phong Reflection Model</a>.

3D Engine is a desktop application whch allows user to:

- Load `.obj` files with coordinates and visualize 3D objects created in Microsoft 3D Builder;
- Perform operations:
  - Translations: Up, Down, Right, Left, Front, Back;
  - Rotations: axes OX, OY, OZ;
  - Zoom: In and Out.

### Used Technologies

- `Java 8`
- `JavaFX 8.0.241`
- `Git`
- `Netbeans 12.0`
- `Microsoft – 3D Builder`

---

### Imported Files Structure

```txt
# Exported from 3D Builder
o Object.1
v 0.427299 1.315100 0.047860
v 1.382801 0.000000 0.047860
v 0.000000 0.000000 0.000000
v -1.118700 0.812799 0.047860
v -1.118700 -0.812799 0.047860
v 0.427299 -1.315201 0.047860
v -0.691999 -2.129900 0.125780
v -2.232100 -1.621700 0.191220
v -2.239500 0.000000 0.125780
v -3.356800 -0.809401 0.300340
v -3.356800 0.809401 0.300340
v -2.232100 1.621700 0.191220
v -0.691999 2.129900 0.125780
...
v 0.000000 0.000000 40.000000
v -1.382799 0.000000 39.952103
v -0.427299 1.315100 39.952103
v 1.118700 0.812799 39.952103

f 1 2 3
f 4 1 3
f 5 4 3
f 6 5 3
f 6 7 5
f 7 8 5
f 5 8 9
f 8 10 9
f 10 11 9
f 9 11 12
f 9 12 4
f 4 12 13
f 12 14 13
f 14 15 13
...

```

Where:

- v (vertex) – (x,y,z) coordinates of points;
- f (face) – numbers corresponding to individual vertices forming a face (triangle).

---

### Screenshots

- Smooth Toruses:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/toruses.png" width=100%>

- Smooth Toruses2:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/toruses_2.png" width=100%>

- Smooth spheres:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/spheres.png" width=100%>

- Simple Toruses:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/toruses_simple.png" width=100%>

- Simple spheres:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/spheres_simple.png" width=100%>

- Simple spheres2:
  <img src="https://github.com/KKofta/engine-3D/blob/master/Screenshots/spheres_simple_2.png" width=100%>

---
