package com.october

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.twitter.util._
import com.october._

class RecHandlerSuite extends FunSuite with BeforeAndAfter {

    var handler: RecHandler = _

    before {
        handler = new RecHandler
    }

    test("ping pongs when pinged") {
        assert(handler.ping.get === "Pong")
    }

    test("placeholder posts are returned with proper weights") {
        var postlist: SPostList = handler.recPosts(0).get
        assert(postlist.length === 10) // This is hardcoded in for now
        assert(postlist.head.weight.get === 1.0) // This is hardcoded in for now
        assert(postlist.last.weight.get === 0.1) // This is hardcoded in for now
    }
}

/*
 * Note:  The following test suites have tests which don't do
 * very much at all.  These are placeholders (for the most part)
 * until useful things are done with these classes.
 *
 * ___ Remember to remove placeholders and this message ___
 */

class PostListSuite extends FunSuite with BeforeAndAfter {

    var postlist: SPostList = _

    before {
        postlist = new SPostList(Option(1.0), Seq())
    }

    test("equality is fun") {
        assert(1 === 1)
    }
}

class PostSuite extends FunSuite with BeforeAndAfter {

    var post: SPost = _

    before {
        post = new SPost(Option(1.0), 0)
    }
    
    test("inequality is also fun") {
        assert(1 < 2)
    }
}