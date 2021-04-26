#!/bin/bash
ssh -fN -L 4125:localhost:4125 guppy
ssh -fN -L 9042:localhost:4126 guppy
ssh -fN -L 7199:localhost:7199 guppy
ssh -fN -L 9160:localhost:9160 guppy
ssh -fN -L 4127:localhost:4127 guppy
ssh -fN -L 4128:localhost:4128 guppy
