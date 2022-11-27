import math
import numpy as np


def dist(t1, t2):
    dis = math.sqrt((np.power(t1[0] - t2[0], 2) + np.power(t1[1] - t2[1], 2) + np.power(t1[2] - t2[2], 2) + np.power(
        t1[3] - t2[3], 2)))
    return dis
