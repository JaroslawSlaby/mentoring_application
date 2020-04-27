package pl.js.juniorasks.dataproviders;

import pl.js.juniorasks.models.BlogWall;

public interface BlogWallProvider {
    BlogWall getMentorBlogWall(String mentorId);
}
