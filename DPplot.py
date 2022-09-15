import matplotlib.pyplot as plt

X = []
prev = 1
for i in range(0, 13):
    l = prev * 2
    X.append(l)
    prev = l


Y = [
    0.025877789,
    0.018156364,
    0.020674637,
    0.019669559,
    0.020017098,
    0.019910504,
    0.019512691,
    0.020835094,
    0.041538053,
    0.168599253,
    1.38100994,
    19.457438809,
    209.306355294,
]
print(X)
plt.plot(X, Y, linestyle="dashed")
X2 = []
prev = 1
for i in range(0, 13):
    l = prev * 2
    X2.append(l)
    prev = l
Y2 = [
    6.6613e-5,
    4.024e-6,
    5.491e-6,
    1.3987e-5,
    4.6004e-5,
    3.06877e-4,
    0.002255698,
    0.003866079,
    0.014029517,
    0.066460103,
    0.417137789,
    8.821972517,
    134.58309282,
]
plt.plot(X2, Y2, linestyle="dotted")
X3 = [1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25]


Y3 = [
    5.9949e-5,
    3.175e-6,
    4.194e-6,
    3.503e-5,
    1.95852e-4,
    2.14611e-4,
    0.001686903,
    0.005490355,
    0.033844865,
    0.233461337,
    1.967427326,
    17.223892503,
    159.580457382,
]
plt.plot(X3, Y3, linestyle="solid")
plt.xlabel("Input size in")
plt.ylabel("Time taken in seconds")
plt.legend(["Top Down", "Bottom Up", "Recursive"])
plt.show()
