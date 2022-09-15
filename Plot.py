import matplotlib.pyplot as plt

X = []
prev = 2
for i in range(0, 15):
    l = prev * 2
    X.append(l)
    prev = l

print(X)

Y = [
    6.4e-5,
    7.6e-5,
    7.1e-5,
    7.3e-5,
    9.0e-5,
    9.2e-5,
    9.32e-4,
    9.3e-5,
    9.2e-5,
    7.2e-5,
    7.4e-5,
    8.5e-5,
    8.4e-5,
    8.8e-5,
    9.6e-5,
]


plt.plot(X, Y, linestyle="dashed")
# plt.legend("Brute Force")


X2 = []
prev = 2
for i in range(0, 15):
    l = prev * 2
    X2.append(l)
    prev = l

print(X2)

Y2 = [
    0.007829,
    0.001521,
    0.001467,
    0.001612,
    0.00208,
    0.002857,
    0.004804,
    0.008973,
    0.017051,
    0.03428,
    0.067517,
    0.129789,
    0.303092,
    0.501523,
    1.100362,
]
plt.plot(X2, Y2, linestyle="dotted")
# plt.legend("YO 2nd half ")


X3 = []
prev = 2
for i in range(0, 15):
    l = prev * 2
    X3.append(l)
    prev = l

print(X3)

Y3 = [
    0.059363,
    0.003608,
    0.002731,
    0.00219,
    0.002251,
    0.002158,
    0.016384,
    0.002432,
    0.00239,
    0.002461,
    0.002581,
    0.0032,
    0.002482,
    0.002943,
    0.012926,
]
plt.plot(X3, Y3, linestyle="solid")
plt.xlabel("Input size in")
plt.ylabel("Time taken in milliseconds")
# plt.show()
X1 = []
prev = 1
for i in range(0, 13):
    l = prev * 2
    X1.append(l)
    prev = l

print(X1)

Y1 = [
    0.004547,
    8.11e-4,
    8.72e-4,
    0.001468,
    0.002831,
    0.006682,
    0.013631,
    0.029192,
    0.050512,
    0.098454,
    0.056307,
    0.133938,
    0.260971,
]
plt.plot(X1, Y1, linestyle=":")
plt.legend(
    [
        "Reversing Entire List",
        "Reversing 2nd Half",
        "Using Stack ",
        "Recursive Solution",
    ]
)
plt.show()
# # plt.legend("Recursion ")
