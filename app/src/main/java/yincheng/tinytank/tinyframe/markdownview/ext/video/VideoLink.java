package yincheng.tinytank.tinyframe.markdownview.ext.video;

import com.vladsch.flexmark.ast.InlineLinkNode;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.util.sequence.BasedSequence;

public class VideoLink extends InlineLinkNode {
	public VideoLink(final Link other) {
		super(other.getChars().baseSubSequence(other.getChars().getStartOffset() - 1, other.getChars().getEndOffset()),
				other.getChars().baseSubSequence(other.getChars().getStartOffset() - 1, other.getTextOpeningMarker().getEndOffset()),
				other.getText(),
				other.getTextClosingMarker(),
				other.getLinkOpeningMarker(),
				other.getUrl(),
				other.getTitleOpeningMarker(),
				other.getTitle(),
				other.getTitleClosingMarker(),
				other.getLinkClosingMarker()
		);
	}

	@Override
	public void setTextChars(BasedSequence textChars) {
		int textCharsLength = textChars.length();
		textOpeningMarker = textChars.subSequence(0, 1);
		text = textChars.subSequence(1, textCharsLength - 1).trim();
		textClosingMarker = textChars.subSequence(textCharsLength - 1, textCharsLength);
	}
}