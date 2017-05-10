salt-channel
============

This repo contains [the specification](files/spec/spec-salt-channel-v1.md) and the 
Java reference implementation of 
*Salt Channel* - a simple, light-weight secure channel protocol based on 
[TweetNaCl](http://tweetnacl.cr.yp.to/) by Bernstein et al.
Salt Channel is "Powered by Curve25519".

Salt Channel is more efficient than TLS. It is simple and
works well on small embedded processors. It has a lower handshake overhead.
See [this comparison](files/salt-channel-vs-tls-2017-05.md).
Salt Channel *always* supports mutual authentication and forward secrecy.
The protocol supports secret client IDs. TLS does not.

The development of the code in this repository and the protocol 
itself has been financed by [ASSA ABLOY AB](http://www.assaabloy.com/) 
-- the global leader in door opening solutions. Thank you for 
supporting this.

We thank Daniel Bernstein for developing the underlying cryptography 
algorithms. Our work here is completely based on his work.
